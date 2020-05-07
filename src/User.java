public abstract class User {

    /*
    * Abstract class for all users of online bank. Users have username,
    * hashed password
    * */

    private String username;
    private String password;

    //constructor
    public User(String username, String password)
    {
        this.username=username;
        this.password= password;
    }

    //no args constructor
    public User()
    {
        this.username= "user";
        this.password= "password";
    }

    public void updateUsername(String u)
    {
        username = u;
    }

    public void updatePassword(String p)
    {
        password = p;
    }


    //getters and setters
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setUsername(String str)
    {
        username= str;
    }
    public void setPassword(String str)
    {
        password= str;
    }
}
