
import ir.maktab.data.ExpertDao;
import ir.maktab.model.Expert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class testExpertSaveImage {
    static ExpertDao expertDao;


    @Test
    public void testSaveExpertDao() throws IOException {


        File file = new File("image1.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Expert expert = new Expert();
        expert.setFirstname("javad");
        expert.setPhoto(bFile);
        expertDao.save(expert);
        Assertions.assertNotNull(expert.getId());
    }


}
