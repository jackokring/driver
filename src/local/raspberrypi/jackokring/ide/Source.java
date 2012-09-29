package local.raspberrypi.jackokring.ide;
/* This is the main source holder class for an IDE.
 * The aim is to have a template driven source edit and build.
 * This will in some aspect require a redefinition of some
 * Java syntax. An example would be class comes before public.
 * This is because class is a type of template, and public
 * is a type specifier. It is important to start the right
 * template, before further specifying it. The Java source
 * loader will mutate the keywords in groups. The jar
 * keyword will be added for jar archive references, while
 * the library keyword will be added for .so/.dll reference.
 * 
 * Certain things will look slightly different. An example
 * being the package definition. Each .sub part of the name
 * will occur on it's own line with some indent. This is
 * because the sub-directory reference is part of the 
 * construction tree. Import statements on the other hand
 * will be on one line, and indented one step in from
 * the last . specification of the preceding package
 * statement. All source will be in one apparent edit.
 * Outline and a bookmark gravity will help locating the
 * relevant edit point.
 * 
 * This unified edit tree prospective is texted based in
 * one window. The title bar shows the tree location.
 * 
 * Using a template system prevents bad formatting and needs
 * the up/down to select template form and then return.
 * Left/right move between template locations. When a single
 * template is selected, up/down move between templates
 * on the same tree level.
 */

public class Source {

}
