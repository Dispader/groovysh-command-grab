import java.util.Map
import groovy.grape.Grape
import org.codehaus.groovy.tools.GrapeUtil
import org.codehaus.groovy.tools.shell.CommandSupport

class GrabCommand extends CommandSupport {

    public static final String COMMAND_NAME = ':grab'

    final String description='Add a dependency to the execution environment'
    final String usage='<dependency|(group name version>)
    final String help='Add a dependency to the Groovy Shell runtime environment.'

    public GrabCommand(org.codehaus.groovy.tools.shell.Groovysh shell) {
        super(shell, COMMAND_NAME, ':g')
    }

    Object execute(List<String> args) {
        if ( args?.size() != 1 && args?.size() != 3 ) {
            fail("usage: @|bold ${COMMAND_NAME}|@ ${usage}")
            // TODO: EVALUATE the following, used by other commands
            //fail(messages.format('error.unexpected_args', args.join(' ')))
        }
        def dep
        if ( args.size() == 3 ) {
            def (group, name, version) = args
            dep = "${group}:${name}:${version}"
        } else {
            dep = args[0]
        }
        Map<String, Object> dependency = GrapeUtil.getIvyParts(dep)
        Grape.grab(dependency)
    }

}
