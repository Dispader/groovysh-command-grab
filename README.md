# Groovy Shell Grab Command

A standalone `:grab` command for the Groovy Shell.

[GROOVY-6514](https://issues.apache.org/jira/browse/GROOVY-6514) is already opened, and has a [proposed Pull Request](https://github.com/apache/groovy/pull/104).  In the meantime, interactively Grabbing dependencies requires a bit of knowledge and typing.

I've found this little Command class useful to tide myself over until a proper `:grab` command makes it into the shell.

## usage

- `groovysh`
- `:load https://git.io/v2N1I` (a short URL to the raw `.groovy` class in GitHub)
- `:register GrabCommand`

## example

```sh
groovy:000> :load https://git.io/v2N1I
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
```

## TODO

- remove import messages during load
- enable CI build / test
