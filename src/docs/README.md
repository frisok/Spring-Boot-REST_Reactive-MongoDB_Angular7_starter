#Requirements

1. MongoDB 3.4.18 installed
2. run Mongod
3. prepare database and collections:
 * use starterdb
 * db.createCollection("user")
 * db.user.insert({username:"some_user_name", password:"some_password",accountNonExpired:true,accountNonLocked:true,credentialsNonExpired:true,enabled:true,authenticationToken:{expiryDate:new Date("2018-01-01T09:00:00"),authenticationToken:""}});
