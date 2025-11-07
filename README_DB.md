# 💎 Belgem – Base de datos en Supabase

## 📘 Descripción general
La base de datos **Belgem** es una instancia de **PostgreSQL** alojada en **Supabase**, usada como entorno centralizado para el desarrollo del ERP de la empresa.

El esquema principal es `v1`, donde se almacenan todas las tablas del sistema (clientes, proveedores, etc.).  
Cada miembro del equipo puede conectarse a esta base desde su propio IntelliJ o cliente SQL, mediante el **Session Pooler** de Supabase.

---

## 🧠 Datos de conexión

| Campo | Valor |
|--------|--------|
| **Host** | `aws-1-eu-north-1.pooler.supabase.com` |
| **Port** | `5432` |
| **Database** | `postgres` |
| **User** | `postgres.ljidznjmengcpgfiqjuc` *(temporal, se usarán roles individuales más adelante)* |
| **Password** | *(se comparte por canal privado)* |
| **SSL mode** | `require` |

> ⚠️ Usa siempre el método **Session pooler**, ya que el plan Nano no soporta conexiones IPv4 directas.

---

## 🗂️ Estructura de carpetas

belgem/
├── db/
│ ├── 00_schema.sql
│ ├── 01_clientes.sql
│ ├── 02_proveedores.sql
│
├── docs/
│ └── README_DB.md
│
└── .gitignore

---

## 🧱 Esquema y tablas base

**Esquema principal:** `v1`

**Tablas creadas:**
- `cliente`
- `proveedor`

```sql
-- 00_schema.sql
CREATE SCHEMA IF NOT EXISTS v1;
SET search_path TO v1, public;


-- 01_clientes.sql
SET search_path TO v1, public;
CREATE TABLE IF NOT EXISTS cliente (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL,
  email VARCHAR(160) UNIQUE,
  telefono VARCHAR(30) UNIQUE,
  fecha_alta TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  activo BOOLEAN NOT NULL DEFAULT TRUE
);


-- 02_proveedores.sql
SET search_path TO v1, public;
CREATE TABLE IF NOT EXISTS proveedor (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(160) NOT NULL,
  email VARCHAR(160) UNIQUE,
  telefono VARCHAR(30) UNIQUE,
  direccion VARCHAR(200),
  fecha_alta TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  activo BOOLEAN NOT NULL DEFAULT TRUE
);
