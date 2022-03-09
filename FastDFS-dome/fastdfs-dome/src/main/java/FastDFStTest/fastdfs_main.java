package FastDFStTest;

import org.csource.common.MyException;

import java.io.IOException;

public class fastdfs_main {
    public static void main(String[] args) throws IOException, MyException {

        fastdfs_util fastdfs_util =new fastdfs_util();

        //fastdfs_util.upload();
        //fastdfs_util.download();
        fastdfs_util.delete_remote_file();
    }
}
