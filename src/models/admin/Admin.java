package models.admin;

import models.exception.MyException;

public class Admin {
    private String name="Baktulan";
    private String surname="Nazirbek uulu";
    private String email;
    private String password;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emails) {
        try {
            if (!emails.equalsIgnoreCase("baku@mail.ru")) {
                throw new MyException("Логин туура эмес!");
            } else{ email = emails;}
        } catch (MyException q) {
            System.out.println(q.getMessage());
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
       this.password = password;
    }

public void changed(String emails, String newP){
        if(emails.equalsIgnoreCase(email)){
            if(!newP.equalsIgnoreCase(getPassword())){
                if(newP.length()>7){
                    setPassword(newP);
                    System.out.println("ok");
                }
            }
        }
}
//    public void changedPassword(String email, String newPassword) {
//        try {
//            if (email.equalsIgnoreCase("baku@mail.ru")) {
//                if (newPassword.length() >= 8) {
//                    if (!newPassword.equalsIgnoreCase(password)) {
//
//                        System.out.println("Жаны пароль ийгиликтуу озгортулду!");
//                    } else if(newPassword.equalsIgnoreCase(password)) {
//                        throw new MyException("Жаны пароль мурунку паролго окшош!");
//                    }
//                } else if (newPassword.length() <= 8){
//                    throw new MyException("Паролдун узундугу 8 символдон узун болушу керек!");
//                }
//            } else if(!email.equalsIgnoreCase("baku@mail.ru")) {
//                throw new MyException("Логин туура эмес");
//            }
//        } catch (MyException m) {
//            System.out.println(m.getMessage());
//        }
//    }


    @Override
    public String toString() {
        return "\nAdmin: " +
                "\nname: " + name +
                "\nsurname: '" + surname +
                "\nemail: " + email +
                "\npassword:" + password ;

    }
}
