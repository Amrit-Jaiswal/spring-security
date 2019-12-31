Spring Security with JWT

Url: Get request
http://localhost:8088/api/v1/hello
Headers:
Content-Type:application/json
Authorization:Bearer XXXXXXXXXXXXXXXXXXX


Url: Post Mapping
http://localhost:8088/api/v1/authenticate

Body:
{
"username":"foo",
"password":"foo"
}
