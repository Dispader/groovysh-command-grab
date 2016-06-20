# Groovy Shell Grab Command

![Release](https://img.shields.io/badge/version-1.0.0-blue.svg)
 [![Analytics](https://ga-beacon.appspot.com/UA-61184208-1/chromeskel_a/readme)](https://github.com/igrigorik/ga-beacon)

A standalone `:grab` command for the Groovy Shell.

![Release](https://img.shields.io/badge/version-1.0.12-blue.svg)

[GROOVY-6514](https://issues.apache.org/jira/browse/GROOVY-6514) is already cleared for the next Apache Groovy release, with a [merged Pull Request adding a `:grab` command](https://github.com/apache/groovy/pull/286).  In the meantime, interactively Grabbing dependencies requires a bit of knowledge and typing.

I've found this little Command class useful to tide myself over until a proper `:grab` command makes it into the shell.

## usage

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
