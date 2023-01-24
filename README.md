# todo-list-springboot-hibernate

A web-facing program that manages a todo list inside a local postgresql server via jpa hibernate, tested with postman. Hibernate removed the need for me to
define any postgres tables or write any SQL queries.

Architecture: postman <---(Spring web mvc / springboot)---> program <---(hibernate)---> local pgsql
