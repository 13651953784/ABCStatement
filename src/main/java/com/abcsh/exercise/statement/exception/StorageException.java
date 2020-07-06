package com.abcsh.exercise.statement.exception;

/**
 * @Author 乘梦碧溪
 * @Date 2020/7/4 22:57
 * @Version 1.0
 */
public class StorageException extends RuntimeException{
    public StorageException(String message){
        super(message);
    }

    public StorageException(String message,Throwable cause){
        super(message,cause);
    }
}
