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
===> true
groovy:000> :register GrabCommand
===> true
groovy:000> :grab 'org.spockframework:spock-core:1.0-groovy-2.4'
groovy:000> import spock.lang.Specification 
===> spock.lang.Specification
groovy:000> 
```

## TODO

- enable CI build / test
