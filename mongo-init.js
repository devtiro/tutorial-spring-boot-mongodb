db.createUser(
        {
            user: "bookstore",
            pwd: "fnwM<Sj^%CDyc@",
            roles: [
                {
                    role: "readWrite",
                    db: "bookstore"
                }
            ]
        }
);