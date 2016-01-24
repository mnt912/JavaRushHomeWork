package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution
{
    public final static class Constants
    {
        public final static String NOT_ACCESSIBLE = "Server is not accessible for now.";
        public final static String NOT_AUTHORIZED = "User is not authorized.";
        public final static String IS_BANNED = "User is banned.";
        public final static String IS_DENIED = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception
    {
        public ServerNotAccessibleException() {
            super(Constants.NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception
    {
        public UnauthorizedUserException() {
            super(Constants.NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception
    {
        public BannedUserException() {
            super(Constants.IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception
    {
        public RestrictionException() {
            super(Constants.IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.IS_DENIED, cause);
        }
    }
}
