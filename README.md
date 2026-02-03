## RCCMS_1 — Church Compliance Monitoring System

RCCMS_1 is a Java Swing desktop application (NetBeans/Ant project) for managing **church compliance inspections**:
church registration, inspection standards, inspections, inspectors, and compliance reporting/analytics.

## Features

- **Authentication**: login/register with roles
- **Church management**: register & manage churches
- **Standards management**: define inspection standards
- **Inspection workflow**: create inspections + details
- **Reporting**: compliance reports and analytics dashboard

## Tech stack

- **Java**: JDK 8 (source/target 1.8)
- **UI**: Swing (NetBeans `.form` screens)
- **Database**: PostgreSQL
- **Build**: Ant (NetBeans)
- **Persistence**: JDBC utilities + (optional) JPA/Hibernate configuration

## Getting started

### Prerequisites

- **JDK 8**
- **NetBeans** (recommended for `.form` editing) or Ant installed
- **PostgreSQL** (local or remote)
- PostgreSQL JDBC driver on classpath

### Database setup

This repository is **safe for public GitHub**: it does **not** commit real database credentials.

To run locally, create a file named `db.properties` in the project root (it is ignored by git).
You can copy `db.properties.example` and edit it.

By default, the example is configured to connect to:

- **DB name**: `church_compliance_monitoring_system_db`
- **Host/port**: `localhost:5432`
- **User**: `postgres`
- **Password**: set your own locally (not committed)

The app reads DB settings from:

- `db.properties` (recommended), or environment variables:
  - `RCCMS_DB_URL`
  - `RCCMS_DB_USER`
  - `RCCMS_DB_PASSWORD`

Used by:

- **JDBC**: `src/rccms/server/util/DatabaseConnection.java`
- **JPA/Hibernate**: `src/rccms/server/util/JPAUtil.java` (persistence unit: `RCCMS_PU`)

### Run in NetBeans

- Open the project folder `RCCMS_1`
- Click **Clean and Build**
- Click **Run**

NetBeans main class is configured as:

- `rccms.RCCMS` (see `nbproject/project.properties`)

### Build/Run from command line (after building)

After NetBeans builds, it produces `dist/RCCMS_1.jar`.

From the `dist` folder:

```bash
java -jar "RCCMS_1.jar"
```

NetBeans will copy required jars to `dist/lib` and set the manifest Class-Path automatically.

## Project structure

- `src/rccms/client/`: UI and client-side helpers
- `src/rccms/common/`: shared domain classes + service interfaces
- `src/rccms/server/`: DAO + service implementations + database utilities
- `src/META-INF/persistence.xml`: JPA persistence configuration (Hibernate provider)
- `nbproject/`: NetBeans project metadata

## Screenshots

Preview (existing image in the repo):

![RCCMS Preview](src/rccms/client/view/3d-rendering-church-building(1).jpg)

Add your real UI screenshots here (recommended):

- `docs/screenshots/login.png`
- `docs/screenshots/dashboard.png`
- `docs/screenshots/inspection.png`

Then embed them like:

![Login](docs/screenshots/login.png)
![Dashboard](docs/screenshots/dashboard.png)

## Troubleshooting

- **Database connection error**: confirm PostgreSQL is running and your URL/user/password match.
- **Driver not found**: ensure PostgreSQL JDBC jar is on the project classpath in NetBeans.
- **CRLF/LF warnings on Windows**: safe to ignore; it’s just line-ending normalization.

## License

MIT — see `LICENSE`.


