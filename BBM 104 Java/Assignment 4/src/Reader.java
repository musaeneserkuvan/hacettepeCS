
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
public interface Reader {

    default void ReadBackupdat(Datas datas) throws Exception{


        File backupOBJ = new File("assets\\data\\backup.dat");
        Scanner backupOBJ2 = new Scanner(backupOBJ);

        File backupOBJ3 = new File("assets\\data\\backup.dat");
        Scanner backupOBJ4 = new Scanner(backupOBJ3);

        while (backupOBJ2.hasNextLine() && backupOBJ4.hasNextLine()){

            String s = backupOBJ2.nextLine();
            String[] argsline = backupOBJ4.nextLine().split("\t");

            if(Objects.equals(argsline[0], "user")){
                datas.setUserslist(s);
            }
            else if (Objects.equals(argsline[0], "film")){
                datas.setFilmlist(s);
            }
            else if (Objects.equals(argsline[0], "hall")){
                datas.setHalslist(s);
            }
            else if (Objects.equals(argsline[0], "seat")){
                datas.setSeatlist(s);
            }
        }


    }

    default void ReadPropertiesDat(Datas datas) throws Exception{

        File propertiesOBJ = new File("assets/data/properties.dat");
        Scanner propertiesOBJ2 = new Scanner(propertiesOBJ);

        while (propertiesOBJ2.hasNextLine()) {
            String Line = propertiesOBJ2.nextLine();
            datas.setPropertieslist(Line);
        }
        propertiesOBJ2.close();
    }

    default void ReadEffects(Datas datas)throws Exception{

        datas.setErrorsound(new Media(new File("assets/effects/error.mp3").toURI().toURL().toString()));

    }

    default void ReadIcons(Datas datas)throws Exception{


        datas.setDisabledseat(new FileInputStream("assets\\icons\\disabledseat.png"));

        datas.setEmptyseat(new FileInputStream("assets\\icons\\empty_seat.png"));

        datas.setHctplogo(new Image(Files.newInputStream(Paths.get("assets\\icons\\hctp.png"))));

        datas.setMovie(new Image(Files.newInputStream(Paths.get("assets\\icons\\movies.png"))));

        datas.setHalls(new Image(Files.newInputStream(Paths.get("assets\\icons\\halls.png"))));


        datas.setLogo(new FileInputStream("assets\\icons\\logo.png"));

        datas.setReservedseat(new FileInputStream("assets\\icons\\reserved_seat.png"));

    }
    default void ReadTrailers(Datas datas)throws Exception{

        for (Films f : datas.getFilmsArrayList()){
            f.setMediaplayer(new MediaPlayer(new Media(new File("assets\\trailers\\"+f.getTrailerpath()).toURI().toURL().toString())));
            f.setMediaview(f.getMediaplayer());
        }
    }


}