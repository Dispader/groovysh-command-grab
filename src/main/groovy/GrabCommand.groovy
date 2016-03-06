class GrabCommand extends org.codehaus.groovy.tools.shell.CommandSupport {

    public static final String COMMAND_NAME = ':grab'

    final String description='Add a dependency to the execution environment'
    final String usage='<dependency|(group name version>)>'
    final String help='Add a dependency to the Groovy Shell runtime environment.'

    private static final java.util.prefs.Preferences PREFERENCES =
        java.util.prefs.Preferences.userRoot().node("/org/codehaus/groovy/tools/shell");

    public GrabCommand(org.codehaus.groovy.tools.shell.Groovysh shell) {
        super(shell, COMMAND_NAME, ':g')
    }

    Object execute(List<String> args) {
        validate(args)
        grab(getDependency(args))
        reloadImportCompletion()
    }

    private void validate(List<String> args) {
        if ( args?.size() != 1 && args?.size() != 3 ) {
            fail("usage: @|bold ${COMMAND_NAME}|@ ${usage}")
        }
    }

    private String getDependency(List<String> args) {
        if ( args.size() == 3 ) {
            def (group, name, version) = args
            "${group}:${name}:${version}"
        } else {
            args[0]
        }
    }

    private void grab(String dependency) {
        Map<String, Object> dependencyMap = org.codehaus.groovy.tools.GrapeUtil.getIvyParts(dependency)
        groovy.grape.GrapeIvy grapeIvy = groovy.grape.Grape.instance
        grapeIvy.grab([classLoader: shell.interp.classLoader.parent,refObject: shell.interp], dependencyMap)
    }

    private void reloadImportCompletion() {
        shell.packageHelper.preferenceChange(ignorePackageCompletion(true))
        shell.packageHelper.preferenceChange(ignorePackageCompletion(false))
    }

    java.util.prefs.PreferenceChangeEvent ignorePackageCompletion(Boolean complete) {
        new java.util.prefs.PreferenceChangeEvent(PREFERENCES,
            org.codehaus.groovy.tools.shell.util.PackageHelper.IMPORT_COMPLETION_PREFERENCE_KEY,
            complete as String)
    }

}
