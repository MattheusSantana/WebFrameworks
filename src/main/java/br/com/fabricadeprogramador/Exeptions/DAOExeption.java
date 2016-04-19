package br.com.fabricadeprogramador.Exeptions;

/**
 * Created by Matheus on 18/04/2016.
 */
public class DAOExeption extends Throwable {


    public DAOExeption(String msg) {
        super(msg);
    }

    public DAOExeption(String s, String message) {
        super();
    }
}
