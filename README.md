# playground

This is a devcontainer quickstart to accompany the [kit-clj guestbook tutorial](https://kit-clj.github.io/docs/guestbook.html).  You can run it one of several ways:

## Clone this repo and start the devcontainer via VSCode and Docker Desktop

1. Clone this repo
2. Open your local copy in VSCode
3. Run the VSCode command `Dev Containers: Open Folder in Container..`


## Quickstart Github Codespaces
If you have configured your Github account, you can start the project without any other setup.  It will open a web-based vscode editor backed by a Github Codespace VM. (Codespaces is Github's hosted Devcontainer solution)

[![Open in Github Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new/kit-clj/playground)

Once the container starts, run the following commands to initialize the project, and start the nREPL

```bash
clojure -Tclj-new create :template io.github.kit-clj :name yourname/guestbook
cd guestbook
```
### Starting the REPL

The REPL can be started by running the following command from the project folder:

```shell
clj -M:dev:nrepl
```

Once the REPL starts you should see the following in the terminal, note that the PORT is selected at random:

```shell
nREPL server started on port 65110 on host localhost - nrepl://localhost:65110
nREPL 0.9.0
Clojure 1.11.1
OpenJDK 64-Bit Server VM 17.0.1+12-39
Interrupt: Control+C
Exit:      Control+D or (exit) or (quit)
user=>
```

Once you see the prompt, you can connect your editor to the REPL. We'll go through connecting Calva, but other editors should work similarly.

* Click on the `REPL` button at the bottom left.
* Select `Connect to a running REPL in your project`
* Select `deps.edn`
* Press `enter`, correct port should be detected automatically.

If everything went well then you should see the following prompt:

```clojure
; Connecting ...
; Hooking up nREPL sessions...
; Connected session: clj
; TIPS:
;   - You can edit the contents here. Use it as a REPL if you like.
;   - `alt+enter` evaluates the current top level form.
;   - `ctrl+enter` evaluates the current form.
;   - `alt+up` and `alt+down` traverse up and down the REPL command history
;      when the cursor is after the last contents at the prompt
;   - Clojure lines in stack traces are peekable and clickable.
clj꞉user꞉> 
```
Let's try starting the server to make sure our application is working.

```clojure
clj꞉user꞉> (go)
:initiated
```
Once the application starts, VS Code will give the option to open the link in browser, the URL will look something like the following
`https://upgraded-system-91a35v996cpw44-3000.app.github.dev/`.
If you switch it to `https://upgraded-system-91a35v996cpw44-3000.app.github.dev/api/health`, then you should see the status opage for the app.

## Running with a different editor

### IntelliJ

[IntelliJ devcontainer support](https://www.jetbrains.com/help/idea/connect-to-devcontainer.html)

### Emacs, Vi, Cli

You can use the [devcontainer cli](https://github.com/devcontainers/cli) to start a devcontainer at the command line.  There are a number of ways to interact with it from emacs.  We are tracking this sort of usage [here](https://github.com/jwhitlark/cnc-devcontainer-templates/issues/3)

# Continuing with the Guestbook tutorial
Once you're running in a devcontainer, open a terminal and jump to the [anatomy of a Kit application](https://kit-clj.github.io/docs/guestbook.html#anatomy_of_a_kit_application) in the tutorial.
