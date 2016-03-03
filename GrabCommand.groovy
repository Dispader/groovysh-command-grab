import java.util.Map
import groovy.grape.Grape
import org.codehaus.groovy.tools.GrapeUtil
import org.codehaus.groovy.tools.shell.*

class GrabCommand extends CommandSupport {

    public static final String COMMAND_NAME = ':grab'

    final String description='Add a dependency to the execution environment'
    final String usage="(Collection[group, name, version])+"
    //String usage='(Collection[group, name, version]|dependency)+'
    final String help='Add a dependency to the Groovy Shell runtime environment.'

    public GrabCommand(org.codehaus.groovy.tools.shell.Groovysh shell) {
        super(shell, COMMAND_NAME, ':g')
    }

    Object execute(List<String> args) {
        if ( args?.size() != 3 ) { fail("${usage}") }
        def (group, name, version) = args
        def shortDependency = "${group}:${name}:${version}"
        Map<String, Object> dependency = GrapeUtil.getIvyParts(shortDependency);
        Grape.grab(dependency)
    }

}
