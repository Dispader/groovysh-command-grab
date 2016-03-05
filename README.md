# Groovy Shell Grab Command

At the moment, this is in a script form, to be loaded in an open Groovy Shell.

## usage

- open `groovysh`
- `:load` the (command class defining) script
- `:register` the command class
- profit

## example

```sh
] groovysh
Groovy Shell (2.4.6, JVM: 1.8.0_60)
Type ':help' or ':h' for help.
--------------------------------------------------------------------------------------------------------------
groovy:000> :load GrabCommand.groovy
===> java.util.Map
===> java.util.Map, groovy.grape.Grape
===> java.util.Map, groovy.grape.Grape, org.codehaus.groovy.tools.GrapeUtil
===> java.util.Map, groovy.grape.Grape, org.codehaus.groovy.tools.GrapeUtil, org.codehaus.groovy.tools.shell.CommandSupport
===> true
groovy:000> :register GrabCommand
===> true
groovy:000> :grab commons-primitives:commons-primitives:1.0
groovy:000> import org.apache.commons.collections.primitives.ArrayIntList
===> java.util.Map, groovy.grape.Grape, org.codehaus.groovy.tools.GrapeUtil, org.codehaus.groovy.tools.shell.CommandSupport, org.apache.commons.collections.primitives.ArrayIntList
groovy:000> :grab org.spockframework spock-core 1.0-groovy-2.4
groovy:000> import spock.lang.Specification
===> java.util.Map, groovy.grape.Grape, org.codehaus.groovy.tools.GrapeUtil, org.codehaus.groovy.tools.shell.CommandSupport, org.apache.commons.collections.primitives.ArrayIntList, spock.lang.Specification
groovy:000>
```

## TODO

- package command class
    - remove import messages during load
- create build, to resolve dependencies
- enable CI build
