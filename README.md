## Rwanda Church Compliance Monitoring System (RCCMS)

RCCMS is a Java Swing desktop application (NetBeans/Ant project) designed to support **church compliance monitoring in Rwanda**.
It helps teams register churches, define inspection standards, record inspections, and produce compliance reports for decision‑making.

## Problem statement (Rwanda)

In Rwanda, the rapid growth of religious institutions has created significant challenges in maintaining safety and regulatory compliance. Currently, church registration, inspection, and monitoring processes are often handled manually through paper-based systems, leading to inefficiencies, safety concerns, and poor regulatory oversight.

Key challenges include:

- **Fragmented records** that are hard to store, search, and verify
- **Inconsistent inspection standards** between inspectors/teams
- **Limited visibility** into compliance status across areas over time
- **Slow reporting and follow-up** due to manual aggregation of findings

Some churches may operate without adequate safety measures, qualified leadership, or sufficient community considerations. RCCMS provides a computerized solution that enables government inspectors to register churches digitally, conduct standardized inspections, track compliance status, and generate comprehensive reports automatically through a user-friendly Java Swing interface integrated with a PostgreSQL database via JDBC.

## Features

- **Authentication**: login/register with roles
- **Church management**: register & manage churches
- **Standards management**: define inspection standards
- **Inspection workflow**: create inspections + details
- **Reporting**: compliance reports and analytics dashboard

## Who it is for (stakeholders)

- **Regulators / local authorities**: view compliance summaries and prioritize follow‑ups
- **Inspectors**: perform inspections using consistent standards and capture results
- **Church administrators**: support corrective actions based on findings (where applicable)

## Typical workflow

1. **Register churches** and maintain accurate profiles
2. Define **inspection standards** (requirements/checklist)
3. Create an **inspection** and record **inspection details** per standard
4. Review **reports/analytics** to track compliance trends and outstanding issues
5. Plan **follow‑ups** based on evidence in the system

## Objectives & scope

### General objective

To provide a reliable digital platform for **registering churches**, conducting **standardized inspections**, tracking **compliance status**, and generating **reports** to support regulatory oversight and public safety in Rwanda.

### Specific objectives

- Digitize church registration and maintain accurate, searchable church profiles
- Standardize inspection criteria through configurable inspection standards/checklists
- Record inspections and findings consistently, including inspection details per standard
- Track compliance status over time and support follow‑up actions
- Generate automatic reports and summaries for decision‑makers
- Improve data availability for planning, monitoring, and accountability

### Target users

- Government inspectors and supervisors
- District/sector officials responsible for oversight
- System administrators (user management, configuration)
- (Optional) Church representatives for providing/confirming required information (if enabled by policy)

### Main modules

- User authentication & role management
- Church registration and management
- Inspection standards management
- Inspections & inspection details capture
- Compliance reporting & analytics

### Scope (what is included)

- Managing churches, inspectors/users, standards, inspections, and reports
- PostgreSQL-backed storage with safe local configuration (`db.properties`)
- NetBeans/Ant build and runnable desktop client

### Out of scope (for now)

- Mobile app / offline field data capture
- Public web portal for citizens
- Integration with national ID systems, payment systems, or external government platforms

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

## Data & privacy note

If you store personal data (e.g., inspector accounts, contact details), treat your database as confidential:

- Use strong passwords (never `123`)
- Limit access to the DB server
- Avoid committing secrets into git (this repo is set up to prevent that)

## License

MIT — see `LICENSE`.


