package laba.objects;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private String password;
    private boolean admin;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        User user = (User) object;
        return (name == user.name ||(name != null && name.equals(user.getName()))) &&
                (password == user.password ||(password != null && password.equals(user.getPassword())));
    }
}
