DROP SCHEMA public CASCADE;

CREATE SCHEMA public;

---

removing docker files after failed

```shell
docker rm multimes-postgres && docker volume rm multimes-backend_pgdata
```
