package mypackage;
public class CheckerBean {
    private String name,email,hob,gender,error,age;
    public CheckerBean(){error="";}
    public void setName(String n){name=n;}
    public void setEmail(String e){email=e;}
    public void setHobbie(String h){hob=h;}
    public void setGender(String g){gender=g;}
    public void setAge(String a){age=a;}
    public void setError(String e){error=e;}
    
    public String getError(){return error;}
    public String getAge(){return age;}
    public String getGender(){return gender;}
    public String getHobbie(){return hob;} //array of objcts
    public String getEmail(){return email;}
    public String getName(){return name;}
    
    public boolean validate()
    {
        boolean res=false;
        if(name.trim().equals("") || (name==null))
        {
            error+="<br>Enter first name";
            res=false;
        }       
        if(age.length()>2 || (age==null))
        {
            error+="<br>Age invalid";
            res=false;
        }
        return true;
    }
}
