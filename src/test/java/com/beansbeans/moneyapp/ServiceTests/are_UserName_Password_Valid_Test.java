package com.beansbeans.moneyapp.ServiceTests;

import com.beansbeans.moneyapp.Services.ValidateUserNamePassword;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.confirmPasswordHash;
import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.makeHash;

public class are_UserName_Password_Valid_Test {
private ValidateUserNamePassword valid = new ValidateUserNamePassword();


    @Test
    public void userNamePasswordTest01() {
        Boolean ans;
        String name = "ABcd123?";
        ans = valid.isUserNameValid(name);
        Assert.assertTrue(ans);
    }

    @Test
        public void userNamePasswordTest02() {
            Boolean ans;
            String name = "bcdef?9";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest03() {
            Boolean ans;
            String name = "ABCDEF?9";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest04() {
            Boolean ans;
            String name = "abcDEFf?";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest05() {
            Boolean ans;
            String name = "ABCabcdef$ 9";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }


        @Test
        public void userNamePasswordTest06() {
            Boolean ans;
            String name = "bbbcdXef?9";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest07() {
            Boolean ans;
            String name = "Abcdf?9";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest08() {
            Boolean ans;
            String name = "HHHHgtabchhhhhhhhhdXef?9";
            ans =  valid.isUserNameValid(name);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest09() {
            Boolean ans;
            String Pass = "good123$";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest10() {
            Boolean ans;
            String Pass = "GOOD123$";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest11() {
            Boolean ans;
            String Pass = "Goodeee$";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest12() {
            Boolean ans;
            String Pass = "Goodaaa123$";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest13() {
            Boolean ans;
            String Pass = "Gooda a123$";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest14() {
            Boolean ans;
            String Pass = "Goodaa12345";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest15() {
            Boolean ans;
            String Pass = "GoodANDf?94";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

        @Test
        public void userNamePasswordTest16() {
            Boolean ans;
            String Pass = "GoodNOTf?94";
            ans =  valid.isPasswordValid(Pass);
            Assert.assertFalse(ans);
        }

    @Test
    public void makeHashTest01() {
        String passWord = "AlexanderBrown1234!";
        String hash =  makeHash(passWord);
        Assert.assertTrue(BCrypt.checkpw(passWord, hash));
    }

    @Test
    public void confirmPasswordHashTest02() {
        String passWord = "AlexanderBrown1234!";
        String hash =  makeHash(passWord);
        Assert.assertTrue(confirmPasswordHash(passWord, hash));
    }
}
