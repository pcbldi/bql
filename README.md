Bql
-------------------------------

Sql Builder in Groovy

Provides easier methods and builders to generate SQL.
Example Usage -

```
 SqlBuilder builder = new SqlBuilder()
  builder.select(["val"])
         .from("table1")
         .build()
```

Or use the DSL as

```
  String query = SqlBuilder.build {
    select ["val1"]
    from "table1"
  }
```
