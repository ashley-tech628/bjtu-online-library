# Public edition validation

- Vue production asset build: passed with Vite 4.4.11 using the recovered local dependency directory. The build used the Vite API with equivalent Vue/JSX plugins and alias settings to avoid a sandbox ancestor-directory access failure during config bundling. It was not a fresh `npm ci` or a TypeScript type check.
- Resolved the missing mobile registration component by redirecting that route to the existing registration view.
- Corrected bare image asset imports in two Vue components.
- Build warnings remain for inherited CSS font/image references and bundle size; production UI behavior has not been checked in a browser.
- Original configuration/password literals checked against the exported text sources: absent.
- Third-party ebook directory, original SQL/account dumps, IDE metadata, compiled outputs and dependency directories: excluded from the export.
- Starter schema: ten source-mapped tables and one synthetic catalog entry. It has not been applied to a database in this environment.
- Source API inventory: 19 controllers. No successful live API or load-test result is claimed.
- Java backend startup: not executed; a Java runtime was not available and the Docker daemon was not running.
- GitHub push: not performed by the packaging environment because its account configuration could not be read. Run `publish-github.ps1` in the account owner's PowerShell.

No benchmark latency, concurrency, reliability or distributed consistency results are inferred from these checks.
