# S3 Package Parameter

A rather specific use-case. A Jenkins plugin that will look up a AWS S3 hosted Apt or Yum repo's database, and glean any information needed to populate a Jenkins parameter dropdown. The primary driver for me to develop this was the ability to look up the packages in the repo in order to call MCollective with a package that we know exists.

## Development

Run jenkins with maven

```
~/<path_to_project>$ mvn hpi:run
```

## Roadmap

* Sort build list by version

## Meta

Alex Rocha - [about.me](http://about.me/alex.rochas)
