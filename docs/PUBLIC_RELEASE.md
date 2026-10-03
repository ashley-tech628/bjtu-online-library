# Public release scope

This release contains the course project's source code and public documentation. Third-party ebook files, original account SQL, database exports, private environment settings, compiled outputs, IDE state and dependency folders are omitted.

Database passwords, JWT signing material and Jasypt encryption settings are supplied through environment variables. Institution-specific frontend redirects were replaced with the current origin; optional WeCom identifiers are environment configured.

`schema-starter.sql` is generated from model mappings and contains one synthetic catalog entry. It is a starter schema, not the original database backup. Authentication role grants and account provisioning require additional setup before full end-to-end use.

This is an academic source release. Some controller permission annotations are commented out in the original implementation, and the inherited authentication/configuration code needs a deployment review. Run locally while reviewing authorization, input validation and framework dependencies. No production deployment or performance benchmark is claimed.
