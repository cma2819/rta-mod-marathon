# rta-mod-marathon

## Development with VSCode

This repository has .devcontainer directory. It is recommended to develop with [Remote Container with VSCode](https://code.visualstudio.com/docs/remote/containers).

1. Clone this repository.
2. Just open the folder with VSCode.
3. VSCode suggests "Reopen in container" because this repository has .devcontainer. Then reopen the folder in container, complete to build worksppace!

### Checkstyle

This repository has checkstyle configuration from [Google Checks](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml).

You must edit extention's setting to enable to check with [Checkstyle for Java extension](https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-checkstyle).

```json
{
    "java.checkstyle.configuration": "${workspaceFolder}/config/checkstyle/checkstyle.xml",
    "java.checkstyle.version": "9.0"
}
```

### Troubleshoot

**Sometimes build Java project failed by "Lombok Annotations Support for VS Code" extension.**

It would be worked after the extension installed. So reloading window solves the error.