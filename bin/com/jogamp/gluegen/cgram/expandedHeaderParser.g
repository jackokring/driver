header {
        package com.jogamp.gluegen.cgram;

        import java.io.*;
        import java.util.*;

        import antlr.CommonAST;
        import com.jogamp.gluegen.cgram.types.*;
}
class HeaderParser extends TreeParser;

options {
	k= 1;
	buildAST= false;
	ASTLabelType= "TNode";
	codeGenMakeSwitchThreshold= 2;
	codeGenBitsetTestThreshold= 3;
	importVocab=GnuCTreeParser;
}

{
    /** Name assigned to a anonymous EnumType (e.g., "enum { ... }"). */
    public static final String ANONYMOUS_ENUM_NAME = "<anonymous>";

    boolean debug = false;

    public boolean getDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /** Set the dictionary mapping typedef names to types for this
        HeaderParser. Must be done before parsing. */
    public void setTypedefDictionary(TypeDictionary dict) {
        this.typedefDictionary = dict;
    }

    /** Returns the typedef dictionary this HeaderParser uses. */
    public TypeDictionary getTypedefDictionary() {
        return typedefDictionary;
    }    
    
    /** Set the dictionary mapping struct names (i.e., the "foo" in
        "struct foo { ... };") to types for this HeaderParser. Must be done
        before parsing. */
    public void setStructDictionary(TypeDictionary dict) {
        this.structDictionary = dict;
    }

    /** Returns the struct name dictionary this HeaderParser uses. */
    public TypeDictionary getStructDictionary() {
        return structDictionary;
    }    
    
    /** Get the canonicalization map, which is a regular HashMap
        mapping Type to Type and which is used for looking up the unique
        instances of e.g. pointer-to-structure types that have been typedefed
        and therefore have names. */
    public Map getCanonMap() {
        return canonMap;
    }

    /** Pre-define the list of EnumTypes for this HeaderParser. Must be
                done before parsing. */
    public void setEnums(List/*<EnumType>*/ enumTypes) {
        // FIXME: Need to take the input set of EnumTypes, extract all
        // the enumerates from each EnumType, and fill in the enumHash
        // so that each enumerate maps to the enumType to which it
        // belongs.
                throw new RuntimeException("setEnums is Unimplemented!");
    }

    /** Returns the EnumTypes this HeaderParser processed. */
    public List/*<EnumType>*/ getEnums() {
        return new ArrayList(enumHash.values());
    }    
    
    /** Clears the list of functions this HeaderParser has parsed.
        Useful when reusing the same HeaderParser for more than one
        header file. */
    public void clearParsedFunctions() {
        functions.clear();
    }

    /** Returns the list of FunctionSymbols this HeaderParser has parsed. */
    public List getParsedFunctions() {
        return functions;
    }

    private CompoundType lookupInStructDictionary(String typeName,
                                                  CompoundTypeKind kind,
                                                  int cvAttrs) {
        CompoundType t = (CompoundType) structDictionary.get(typeName);
        if (t == null) {
            t = CompoundType.create(null, null, kind, cvAttrs);
            t.setStructName(typeName);
            structDictionary.put(typeName, t);
        }
        return t;
    }

    private Type lookupInTypedefDictionary(String typeName) {
        Type t = typedefDictionary.get(typeName);
        if (t == null) {
            throw new RuntimeException("Undefined reference to typedef name " + typeName);
        }
        return t;
    }

    static class ParameterDeclaration {
        private String id;
        private Type   type;

        ParameterDeclaration(String id, Type type) {
            this.id = id;
            this.type = type;
        }
        String id()             { return id; }
        Type   type()           { return type; }
    }

    // A box for a Type. Allows type to be passed down to be modified by recursive rules.
    static class TypeBox {
        private Type origType;
        private Type type;
        private boolean isTypedef;

        TypeBox(Type type) {
            this(type, false);
        }

        TypeBox(Type type, boolean isTypedef) {
            this.origType = type;
            this.isTypedef = isTypedef;
        }

        Type type() {
            if (type == null) {
                return origType;
            }
            return type;
        }
        void setType(Type type) {
            this.type = type;
        }
        void reset() {
            type = null;
        }

        boolean isTypedef()     { return isTypedef; }

            // for easier debugging
            public String toString() { 
               String tStr = "Type=NULL_REF";
               if (type == origType) {
                         tStr = "Type=ORIG_TYPE";
                     } else if (type != null) {
                     tStr = "Type: name=\"" + type.getCVAttributesString() + " " + 
                    type.getName() + "\"; signature=\"" + type + "\"; class " + 
                                        type.getClass().getName();
               }
               String oStr = "OrigType=NULL_REF";
               if (origType != null) {
                     oStr = "OrigType: name=\"" + origType.getCVAttributesString() + " " + 
             origType.getName() + "\"; signature=\"" + origType + "\"; class " + 
                        origType.getClass().getName();
               }
               return "<["+tStr + "] [" + oStr + "] " + " isTypedef=" + isTypedef+">"; 
            }
    }

    private String getTypeString(Type t) {
      StringBuffer sb = new StringBuffer();
      sb.append("[");
      sb.append(t);
      sb.append(", size: ");
      if(null!=t) {
        SizeThunk st = t.getSize();
        if(null!=st) {
          sb.append(st.getClass().getName());
        } else {
          sb.append("undef");
        }
      }
      sb.append("]");
      return sb.toString();
    }

    private void debugPrintln(String msg) {
        if(debug) {
            System.err.println(msg);
        }
    }

    private void debugPrint(String msg) {
        if(debug) {
            System.err.print(msg);
        }
    }

    private boolean doDeclaration;   // Used to only process function typedefs
    private String  declId;
    private List    parameters;
    private TypeDictionary typedefDictionary;
    private TypeDictionary structDictionary;
    private List/*<FunctionSymbol>*/ functions = new ArrayList();
    // hash from name of an enumerated value to the EnumType to which it belongs
    private HashMap/*<String,EnumType>*/ enumHash = new HashMap();

    // Storage class specifiers
    private static final int AUTO     = 1 << 0;
    private static final int REGISTER = 1 << 1;
    private static final int TYPEDEF  = 1 << 2;
    // Function storage class specifiers
    private static final int EXTERN   = 1 << 3;
    private static final int STATIC   = 1 << 4;
    private static final int INLINE   = 1 << 5;
    // Type qualifiers
    private static final int CONST    = 1 << 6;
    private static final int VOLATILE = 1 << 7;
    private static final int SIGNED   = 1 << 8;
    private static final int UNSIGNED = 1 << 9;

    private void initDeclaration() {
        doDeclaration = false;
        declId = null;
    }

    private void doDeclaration() {
        doDeclaration = true;
    }

    private void processDeclaration(Type returnType) {
        if (doDeclaration) {
            FunctionSymbol sym = new FunctionSymbol(declId, new FunctionType(null, null, returnType, 0));
                if (parameters != null) { // handle funcs w/ empty parameter lists (e.g., "foo()")
                for (Iterator iter = parameters.iterator(); iter.hasNext(); ) {
                    ParameterDeclaration pd = (ParameterDeclaration) iter.next();
                    sym.addArgument(pd.type(), pd.id());
                }
                }
            functions.add(sym);
        }
    }

    private int attrs2CVAttrs(int attrs) {
        int cvAttrs = 0;
        if ((attrs & CONST) != 0) {
            cvAttrs |= CVAttributes.CONST;
        }
        if ((attrs & VOLATILE) != 0) {
            cvAttrs |= CVAttributes.VOLATILE;
        }
        return cvAttrs;
    }

    /** Helper routine which handles creating a pointer or array type
        for [] expressions */
    private void handleArrayExpr(TypeBox tb, AST t) {
        if (t != null) {
            try {
                int len = parseIntConstExpr(t);
                tb.setType(canonicalize(new ArrayType(tb.type(), SizeThunk.mul(SizeThunk.constant(len), tb.type().getSize()), len, 0)));
                return;
            } catch (RecognitionException e) {
                // Fall through
            }
        }
        tb.setType(canonicalize(new PointerType(SizeThunk.POINTER,
                                                tb.type(),
                                                0)));
    }

    private int parseIntConstExpr(AST t) throws RecognitionException {
        return intConstExpr(t);
    }

  /** Utility function: creates a new EnumType with the given name, or
          returns an existing one if it has already been created. */
  private EnumType getEnumType(String enumTypeName) {
        EnumType enumType = null;
        Iterator it = enumHash.values().iterator(); 
        while (it.hasNext()) {
          EnumType potentialMatch = (EnumType)it.next();
          if (potentialMatch.getName().equals(enumTypeName)) {
                enumType = potentialMatch;
                break;        
          }
        }
        
        if (enumType == null) {
      // This isn't quite correct. In theory the enum should expand to
      // the size of the largest element, so if there were a long long
      // entry the enum should expand to e.g. int64. However, using
      // "long" here (which is what used to be the case) was 
      // definitely incorrect and caused problems.
          enumType = new EnumType(enumTypeName, SizeThunk.INT32);
        }  
        
        return enumType;
  }        
  
  // Map used to canonicalize types. For example, we may typedef
  // struct foo { ... } *pfoo; subsequent references to struct foo* should
  // point to the same PointerType object that had its name set to "pfoo".
  private Map canonMap = new HashMap();
  private Type canonicalize(Type t) {
    Type res = (Type) canonMap.get(t);
    if (res != null) {
      return res;
    }
    canonMap.put(t, t);
    return t;
  }
}
declarator[TypeBox tb] returns [String s]{
    initDeclaration();
    s = null;
    List params = null;
    String funcPointerName = null;
    TypeBox dummyTypeBox = null;
}
:#( NDeclarator
                ( pointerGroup[tb] )?

                ( id:ID  { s = id.getText(); }
                | LPAREN funcPointerName = declarator[dummyTypeBox] RPAREN
                )

                (   #( NParameterTypeList
                      (
                        params = parameterTypeList
                        | (idList)?
                      ) 
                      RPAREN
                    )  {
                           if (id != null) {
                               declId = id.getText();
                               parameters = params; // FIXME: Ken, why are we setting this class member here? 
                               doDeclaration();
                           } else if ( funcPointerName != null ) {
                               /* TypeBox becomes function pointer in this case */
                               FunctionType ft = new FunctionType(null, null, tb.type(), 0);
                               if (params == null) {
                                                     // If the function pointer has no declared parameters, it's a 
                                               // void function. I'm not sure if the parameter name is 
                                               // ever referenced anywhere when the type is VoidType, so
                                   // just in case I'll set it to a comment string so it will
                                               // still compile if written out to code anywhere.
                                                     ft.addArgument(new VoidType(0), "/*unnamed-void*/");
                                           } else {
                                                     for (Iterator iter = params.iterator(); iter.hasNext(); ) {
                                     ParameterDeclaration pd = (ParameterDeclaration) iter.next();
                                     ft.addArgument(pd.type(), pd.id());
                                                   }
                               }
                               tb.setType(canonicalize(new PointerType(SizeThunk.POINTER,
                                                                       ft,
                                                                       0)));
                               s = funcPointerName;
                           }
                       }
                 | LBRACKET ( e:expr )? RBRACKET { handleArrayExpr(tb, e); }
                )*
             )
        ;

typelessDeclaration {
    TypeBox tb = null;
}
:#(NTypeMissing initDeclList[tb] SEMI)
        ;

declaration {
    TypeBox tb = null;
}
:#( NDeclaration
                    tb = declSpecifiers 
                    (
                        initDeclList[tb] 
                    )?
                    ( SEMI )+
                ) { processDeclaration(tb.type()); }
        ;

parameterTypeList returns [List l]{ l = new ArrayList(); ParameterDeclaration decl = null; }
:( decl = parameterDeclaration { if (decl != null) l.add(decl); } ( COMMA | SEMI )? )+ ( VARARGS )?
        ;

parameterDeclaration returns [ParameterDeclaration pd]{
    Type t = null;
    String decl = null;
    pd = null;
    TypeBox tb = null;
}
:#( NParameterDeclaration
                tb    = declSpecifiers
                (decl = declarator[tb] | nonemptyAbstractDeclarator[tb])?
                ) { pd = new ParameterDeclaration(decl, tb.type()); }
        ;

functionDef {
    TypeBox tb = null;
}
:#( NFunctionDef
                ( functionDeclSpecifiers)? 
                declarator[tb]
                (declaration | VARARGS)*
                compoundStatement
            )
        ;

declSpecifiers returns [TypeBox tb]{
    tb = null;
    Type t = null;
    int x = 0;
    int y = 0; 
}
:( y = storageClassSpecifier { x |= y; } 
                | y = typeQualifier         { x |= y; }
                | t = typeSpecifier[x]
                )+
{
            if (t == null &&
                (x & (SIGNED | UNSIGNED)) != 0) {
                t = new IntType("int", SizeThunk.INTxx, ((x & UNSIGNED) != 0), attrs2CVAttrs(x));
            }
            tb = new TypeBox(t, ((x & TYPEDEF) != 0));
}
        ;

storageClassSpecifier returns [int x]{ x = 0; }
:"auto"     { x |= AUTO;     }
        |       "register" { x |= REGISTER; }
        |       "typedef"  { x |= TYPEDEF;  }
        |       x = functionStorageClassSpecifier
        ;

functionStorageClassSpecifier returns [int x]{ x = 0; }
:"extern" { x |= EXTERN; }
        |       "static" { x |= STATIC; }
        |       "inline" { x |= INLINE; }
        ;

typeQualifier returns [int x]{ x = 0; }
:"const"    { x |= CONST; }
        |       "volatile" { x |= VOLATILE; }
        |       "signed"   { x |= SIGNED; }
        |       "unsigned" { x |= UNSIGNED; }
        ;

typeSpecifier[int attributes] returns [Type t]{
    t = null;
    int cvAttrs = attrs2CVAttrs(attributes);
    boolean unsigned = ((attributes & UNSIGNED) != 0);
}
:"void"      { t = new VoidType(cvAttrs); }
        |       "char"      { t = new IntType("char" , SizeThunk.INT8,  unsigned, cvAttrs); }
        |       "short"     { t = new IntType("short", SizeThunk.INT16, unsigned, cvAttrs); }
        |       "int"       { t = new IntType("int"  , SizeThunk.INTxx, unsigned, cvAttrs); }
        |       "long"      { t = new IntType("long" , SizeThunk.LONG,  unsigned, cvAttrs); }
        |       "float"     { t = new FloatType("float", SizeThunk.FLOAT, cvAttrs); }
        |       "double"    { t = new DoubleType("double", SizeThunk.DOUBLE, cvAttrs); }
        |       "__int32"   { t = new IntType("__int32", SizeThunk.INT32, unsigned, cvAttrs); }
        |       "__int64"   { t = new IntType("__int64", SizeThunk.INT64, unsigned, cvAttrs); }
        |       "int8_t"    { t = new IntType("int8_t", SizeThunk.INT8, false, cvAttrs); /* TS: always signed */ }
        |       "uint8_t"   { t = new IntType("uint8_t", SizeThunk.INT8, true, cvAttrs); /* TS: always unsigned */ }
        |       "int16_t"   { t = new IntType("int16_t", SizeThunk.INT16, false, cvAttrs); /* TS: always signed */ }
        |       "uint16_t"  { t = new IntType("uint16_t", SizeThunk.INT16, true, cvAttrs); /* TS: always unsigned */ }
        |       "int32_t"   { t = new IntType("int32_t", SizeThunk.INT32, false, cvAttrs); /* TS: always signed */ }
        |       "wchar_t"   { t = new IntType("wchar_t", SizeThunk.INT32, false, cvAttrs); /* TS: always signed */ }
        |       "uint32_t"  { t = new IntType("uint32_t", SizeThunk.INT32, true, cvAttrs, true); /* TS: always unsigned */ }
        |       "int64_t"   { t = new IntType("int64_t", SizeThunk.INT64, false, cvAttrs); /* TS: always signed */ }
        |       "uint64_t"  { t = new IntType("uint64_t", SizeThunk.INT64, true, cvAttrs, true); /* TS: always unsigned */ }
        |       "ptrdiff_t" { t = new IntType("ptrdiff_t", SizeThunk.POINTER, false, cvAttrs); /* TS: always signed */ }
        |       "intptr_t"  { t = new IntType("intptr_t", SizeThunk.POINTER, false, cvAttrs); /* TS: always signed */ }
        |       "size_t"    { t = new IntType("size_t", SizeThunk.POINTER, true, cvAttrs, true); /* TS: always unsigned */ }
        |       "uintptr_t" { t = new IntType("uintptr_t", SizeThunk.POINTER, true, cvAttrs, true); /* TS: always unsigned */ }
        |       t = structSpecifier[cvAttrs] ( attributeDecl )*
        |       t = unionSpecifier [cvAttrs] ( attributeDecl )*
        |       t = enumSpecifier  [cvAttrs] 
        |       t = typedefName    [cvAttrs] 
        |       #("typeof" LPAREN
                    ( (typeName )=> typeName 
                    | expr
                    )
                    RPAREN
                )
        |       "__complex"
        ;

typedefName[int cvAttrs] returns [Type t]{ t = null; }
:#(NTypedefName id : ID)
            {
              Type tdict = lookupInTypedefDictionary(id.getText());
              t = canonicalize(tdict.getCVVariant(cvAttrs));
              debugPrintln("Adding typedef canon : [" + id.getText() + "] -> [" + tdict + "] -> "+getTypeString(t));
            }
        ;

structSpecifier[int cvAttrs] returns [Type t]{ t = null; }
:#( "struct" t = structOrUnionBody[CompoundTypeKind.STRUCT, cvAttrs] )
        ;

unionSpecifier[int cvAttrs] returns [Type t]{ t = null; }
:#( "union" t = structOrUnionBody[CompoundTypeKind.UNION, cvAttrs] )
        ;

structOrUnionBody[CompoundTypeKind kind, int cvAttrs] returns [CompoundType t]{
    t = null;
}
:( (ID LCURLY) => id:ID LCURLY {
                    t = (CompoundType) canonicalize(lookupInStructDictionary(id.getText(), kind, cvAttrs));
                  } ( structDeclarationList[t] )?
                    RCURLY { t.setBodyParsed(); }
                |   LCURLY { t = CompoundType.create(null, null, kind, cvAttrs); }
                    ( structDeclarationList[t] )?
                    RCURLY { t.setBodyParsed(); }
                | id2:ID { t = (CompoundType) canonicalize(lookupInStructDictionary(id2.getText(), kind, cvAttrs)); }
                )
        ;

structDeclarationList[CompoundType t] :( structDeclaration[t] )+
        ;

structDeclaration[CompoundType containingType] {
    Type t = null;
    boolean addedAny = false;
}
:t = specifierQualifierList addedAny = structDeclaratorList[containingType, t] {
                    if (!addedAny) {
                        if (t != null) {
                            CompoundType ct = t.asCompound();
                            if (ct.isUnion()) {
                                // Anonymous union
                                containingType.addField(new Field(null, t, null));
                            }
                        }
                    }
                }
        ;

specifierQualifierList returns [Type t]{
    t = null; int x = 0; int y = 0;
}
:(
                t = typeSpecifier[x]
                | y = typeQualifier { x |= y; }
                )+ {
            if (t == null &&
                (x & (SIGNED | UNSIGNED)) != 0) {
                t = new IntType("int", SizeThunk.INTxx, ((x & UNSIGNED) != 0), attrs2CVAttrs(x));
            }
}
        ;

structDeclaratorList[CompoundType containingType, Type t] returns [boolean addedAny]{
    addedAny = false;
    boolean y = false;
}
:( y = structDeclarator[containingType, t] { addedAny = y; })+
        ;

structDeclarator[CompoundType containingType, Type t] returns [boolean addedAny]{
    addedAny = false;
    String s = null;
    TypeBox tb = new TypeBox(t);
}
:#( NStructDeclarator      
            ( s = declarator[tb] { containingType.addField(new Field(s, tb.type(), null)); addedAny = true; } )?
            ( COLON expr     { /* FIXME: bit types not handled yet */ }        ) ?
            ( attributeDecl )*
        )
        ;

enumSpecifier[int cvAttrs] returns [Type t]{ 
        t = null; 
}
:#( "enum"
                   ( ( ID LCURLY )=> i:ID LCURLY enumList[(EnumType)(t = getEnumType(i.getText()))] RCURLY 
                     | LCURLY enumList[(EnumType)(t = getEnumType(ANONYMOUS_ENUM_NAME))] RCURLY 
                     | ID { t = getEnumType(i.getText()); }
                    )
                  )
        ;

enumList[EnumType enumeration] {
        long defaultEnumerantValue = 0;
}
:( defaultEnumerantValue = enumerator[enumeration, defaultEnumerantValue] )+
      ;

enumerator[EnumType enumeration, long defaultValue] returns [long newDefaultValue]{
        newDefaultValue = defaultValue;
}
:eName:ID ( ASSIGN eVal:expr )? {
                    long value = 0;
                    if (eVal != null) {
                      String vTxt = eVal.getAllChildrenText();
                      if (enumHash.containsKey(vTxt)) {
                        EnumType oldEnumType = (EnumType) enumHash.get(vTxt);
                        value = oldEnumType.getEnumValue(vTxt);
                      } else {
                        try {
                          value = Long.decode(vTxt).longValue();
                        } catch (NumberFormatException e) {
                          System.err.println("NumberFormatException: ID[" + eName.getText() + "], VALUE=[" + vTxt + "]");
                          throw e;
                        }
                      }
                    } else {
                      value = defaultValue;
                    }

                                        newDefaultValue = value+1;
                                          String eTxt = eName.getText();
                                          if (enumHash.containsKey(eTxt)) {
                                                EnumType oldEnumType = (EnumType) enumHash.get(eTxt);
                                                long oldValue = oldEnumType.getEnumValue(eTxt);
                                                  System.err.println("WARNING: redefinition of enumerated value '" + eTxt + "';" +
                                                     " existing definition is in enumeration '" + oldEnumType.getName() +
                                                     "' with value " + oldValue + " and new definition is in enumeration '" +
                                                     enumeration.getName() + "' with value " + value);
                                                // remove old definition
                                                oldEnumType.removeEnumerate(eTxt);
                                          }
                                          // insert new definition
                                          enumeration.addEnum(eTxt, value);
                                          enumHash.put(eTxt, enumeration);
                                        debugPrintln("ENUM [" + enumeration.getName() + "]: " + eTxt + " = " + enumeration.getEnumValue(eTxt) +
                                                     " (new default = " + newDefaultValue + ")");
                                }
            ;

initDeclList[TypeBox tb] :( initDecl[tb] )+
        ;

initDecl[TypeBox tb] {
    String declName = null;
}
:#( NInitDecl
                declName = declarator[tb] { 
                    debugPrintln("GOT declName: " + declName + " TB=" + tb);
                  }
                ( attributeDecl )*
                ( ASSIGN initializer
                | COLON expr
                )?
                )
{
    if ((declName != null) && (tb != null) && tb.isTypedef()) {
        Type t = tb.type();
        debugPrint("Adding typedef mapping: [" + declName + "] -> "+getTypeString(t));
        if (!t.hasTypedefName()) {
            t.setName(declName);
            debugPrint(" - declName -> "+getTypeString(t));
        } else {
            // copy type to preserve declName !
            t = (Type) t.clone();
            t.setName(declName);
            debugPrint(" - copy -> "+getTypeString(t));
        }
        t = canonicalize(t);
        debugPrintln(" - canon -> "+getTypeString(t));
        typedefDictionary.put(declName, t);
        // Clear out PointerGroup effects in case another typedef variant follows
        tb.reset();
    }
}
        ;

pointerGroup[TypeBox tb] { int x = 0; int y = 0; }
:#( NPointerGroup ( STAR { x = 0; y = 0; } ( y = typeQualifier { x |= y; } )*
                                    {
                                        debugPrintln("IN PTR GROUP: TB=" + tb);
                                        if (tb != null) {
                                            tb.setType(canonicalize(new PointerType(SizeThunk.POINTER,
                                                                                    tb.type(),
                                                                                    attrs2CVAttrs(x))));
                                        }
                                    }
                                 )+ )
  ;

functionDeclSpecifiers :( functionStorageClassSpecifier
                | typeQualifier
                | typeSpecifier[0]
                )+
        ;

typeName {
    TypeBox tb = null;
}
:specifierQualifierList (nonemptyAbstractDeclarator[tb])?
        ;

nonemptyAbstractDeclarator[TypeBox tb] :#( NNonemptyAbstractDeclarator
            (   pointerGroup[tb]
                (   (LPAREN  
                    (   nonemptyAbstractDeclarator[tb]
                        | parameterTypeList
                    )?
                    RPAREN)
                | (LBRACKET (e1:expr)? RBRACKET) { handleArrayExpr(tb, e1); }
                )*

            |  (   (LPAREN  
                    (   nonemptyAbstractDeclarator[tb]
                        | parameterTypeList
                    )?
                    RPAREN)
                | (LBRACKET (e2:expr)? RBRACKET) { handleArrayExpr(tb, e2); }
                )+
            )
            )
        ;

intConstExpr returns [int i]{ i = -1; }
:n:Number   { return Integer.parseInt(n.getText()); }
        ;

// inherited from grammar GnuCTreeParser
translationUnit 
options {
	defaultErrorHandler=false;
}
:( externalList )? 
        ;

// inherited from grammar GnuCTreeParser
externalList :( externalDef )+
        ;

// inherited from grammar GnuCTreeParser
externalDef :declaration
        |       functionDef
        |       asm_expr
        |       SEMI
        |       typelessDeclaration
        ;

// inherited from grammar GnuCTreeParser
asm_expr :#( "asm" ( "volatile" )? LCURLY expr RCURLY ( SEMI )+ )
        ;

// inherited from grammar GnuCTreeParser
attributeDecl :#( "__attribute" (.)* )
        | #( NAsmAttribute LPAREN expr RPAREN )
        ;

// inherited from grammar GnuCTreeParser
idList :ID ( COMMA ID )*
        ;

// inherited from grammar GnuCTreeParser
initializer :#( NInitializer (initializerElementLabel)? expr )
                |   lcurlyInitializer
        ;

// inherited from grammar GnuCTreeParser
initializerElementLabel :#( NInitializerElementLabel
                (
                    ( LBRACKET expr RBRACKET (ASSIGN)? )
                    | ID COLON
                    | DOT ID ASSIGN
                )
            )
        ;

// inherited from grammar GnuCTreeParser
lcurlyInitializer :#( NLcurlyInitializer
                initializerList
                RCURLY
            )
        ;

// inherited from grammar GnuCTreeParser
initializerList :( initializer )*
        ;

// inherited from grammar GnuCTreeParser
declarationList :(   //ANTLR doesn't know that declarationList properly eats all the declarations
                    //so it warns about the ambiguity
                    options {
                        warnWhenFollowAmbig = false;
                    } :
                localLabelDecl
                | declaration
                )+
        ;

// inherited from grammar GnuCTreeParser
localLabelDecl :#("__label__" (ID)+ )
        ;

// inherited from grammar GnuCTreeParser
compoundStatement :#( NCompoundStatement
                ( declarationList
                | functionDef
                )*
                ( statementList )?
                RCURLY
                )
        ;

// inherited from grammar GnuCTreeParser
statementList :( statement )+
        ;

// inherited from grammar GnuCTreeParser
statement :statementBody
        ;

// inherited from grammar GnuCTreeParser
statementBody :SEMI                    // Empty statements

        |       compoundStatement       // Group of statements

        |       #(NStatementExpr expr)                    // Expressions

// Iteration statements:

        |       #( "while" expr statement )
        |       #( "do" statement expr )
        |       #( "for"
                expr expr expr
                statement
                )


// Jump statements:

        |       #( "goto" expr )
        |       "continue" 
        |       "break"
        |       #( "return" ( expr )? )


// Labeled statements:
        |       #( NLabel ID (statement)? )
        |       #( "case" expr (statement)? )
        |       #( "default" (statement)? )



// Selection statements:

        |       #( "if"
                    expr statement  
                    ( "else" statement )?
                 )
        |       #( "switch" expr statement )



        ;

// inherited from grammar GnuCTreeParser
expr :assignExpr
        |       conditionalExpr
        |       logicalOrExpr
        |       logicalAndExpr
        |       inclusiveOrExpr
        |       exclusiveOrExpr
        |       bitAndExpr
        |       equalityExpr
        |       relationalExpr
        |       shiftExpr
        |       additiveExpr
        |       multExpr
        |       castExpr
        |       unaryExpr
        |       postfixExpr
        |       primaryExpr
        |       commaExpr
        |       emptyExpr
        |       compoundStatementExpr
        |       initializer
        |       rangeExpr
        |       gnuAsmExpr
        ;

// inherited from grammar GnuCTreeParser
commaExpr :#(NCommaExpr expr expr)
        ;

// inherited from grammar GnuCTreeParser
emptyExpr :NEmptyExpression
        ;

// inherited from grammar GnuCTreeParser
compoundStatementExpr :#(LPAREN compoundStatement RPAREN)
        ;

// inherited from grammar GnuCTreeParser
rangeExpr :#(NRangeExpr expr VARARGS expr)
        ;

// inherited from grammar GnuCTreeParser
gnuAsmExpr :#(NGnuAsmExpr
                ("volatile")? 
                LPAREN stringConst
                ( options { warnWhenFollowAmbig = false; }:
                  COLON (strOptExprPair ( COMMA strOptExprPair)* )?
                  ( options { warnWhenFollowAmbig = false; }:
                    COLON (strOptExprPair ( COMMA strOptExprPair)* )?
                  )?
                )?
                ( COLON stringConst ( COMMA stringConst)* )?
                RPAREN
            )
        ;

// inherited from grammar GnuCTreeParser
strOptExprPair :stringConst ( LPAREN expr RPAREN )?
        ;

// inherited from grammar GnuCTreeParser
assignExpr :#( ASSIGN expr expr)
        |       #( DIV_ASSIGN expr expr)
        |       #( PLUS_ASSIGN expr expr)
        |       #( MINUS_ASSIGN expr expr)
        |       #( STAR_ASSIGN expr expr)
        |       #( MOD_ASSIGN expr expr)
        |       #( RSHIFT_ASSIGN expr expr)
        |       #( LSHIFT_ASSIGN expr expr)
        |       #( BAND_ASSIGN expr expr)
        |       #( BOR_ASSIGN expr expr)
        |       #( BXOR_ASSIGN expr expr)
        ;

// inherited from grammar GnuCTreeParser
conditionalExpr :#( QUESTION expr (expr)? COLON expr )
        ;

// inherited from grammar GnuCTreeParser
logicalOrExpr :#( LOR expr expr) 
        ;

// inherited from grammar GnuCTreeParser
logicalAndExpr :#( LAND expr expr )
        ;

// inherited from grammar GnuCTreeParser
inclusiveOrExpr :#( BOR expr expr )
        ;

// inherited from grammar GnuCTreeParser
exclusiveOrExpr :#( BXOR expr expr )
        ;

// inherited from grammar GnuCTreeParser
bitAndExpr :#( BAND expr expr )
        ;

// inherited from grammar GnuCTreeParser
equalityExpr :#( EQUAL expr expr)
        |       #( NOT_EQUAL expr expr)
        ;

// inherited from grammar GnuCTreeParser
relationalExpr :#( LT expr expr)
        |       #( LTE expr expr)
        |       #( GT expr expr)
        |       #( GTE expr expr)
        ;

// inherited from grammar GnuCTreeParser
shiftExpr :#( LSHIFT expr expr)
                | #( RSHIFT expr expr)
        ;

// inherited from grammar GnuCTreeParser
additiveExpr :#( PLUS expr expr)
        |       #( MINUS expr expr)
        ;

// inherited from grammar GnuCTreeParser
multExpr :#( STAR expr expr)
        |       #( DIV expr expr)
        |       #( MOD expr expr)
        ;

// inherited from grammar GnuCTreeParser
castExpr :#( NCast typeName RPAREN expr)
        ;

// inherited from grammar GnuCTreeParser
unaryExpr :#( INC expr )
        |       #( DEC expr )
        |       #( NUnaryExpr unaryOperator expr)
        |       #( "sizeof"
                    ( ( LPAREN typeName )=> LPAREN typeName RPAREN
                    | expr
                    )
                )
        |       #( "__alignof"
                    ( ( LPAREN typeName )=> LPAREN typeName RPAREN
                    | expr
                    )
                )
        ;

// inherited from grammar GnuCTreeParser
unaryOperator :BAND
        |       STAR
        |       PLUS
        |       MINUS
        |       BNOT
        |       LNOT
        |       LAND
        |       "__real"
        |       "__imag"
        ;

// inherited from grammar GnuCTreeParser
postfixExpr :#( NPostfixExpr
                    primaryExpr
                    ( PTR ID
                    | DOT ID
                    | #( NFunctionCallArgs (argExprList)? RPAREN )
                    | LBRACKET expr RBRACKET
                    | INC
                    | DEC
                    )+
                )
        ;

// inherited from grammar GnuCTreeParser
primaryExpr :ID
        |       Number
        |       charConst
        |       stringConst

// JTC:
// ID should catch the enumerator
// leaving it in gives ambiguous err
//      | enumerator

        |       #( NExpressionGroup expr )
        ;

// inherited from grammar GnuCTreeParser
argExprList :( expr )+
        ;

// inherited from grammar GnuCTreeParser
protected charConst :CharLiteral
        ;

// inherited from grammar GnuCTreeParser
protected stringConst :#(NStringSeq (StringLiteral)+)
        ;

// inherited from grammar GnuCTreeParser
protected intConst :IntOctalConst
        |       LongOctalConst
        |       UnsignedOctalConst
        |       IntIntConst
        |       LongIntConst
        |       UnsignedIntConst
        |       IntHexConst
        |       LongHexConst
        |       UnsignedHexConst
        ;

// inherited from grammar GnuCTreeParser
protected floatConst :FloatDoubleConst
        |       DoubleDoubleConst
        |       LongDoubleConst
        ;


