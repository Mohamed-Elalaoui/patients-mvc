package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            // Création de nouveaux patients
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,120));
            patientRepository.save(new Patient(null,"Mohamed",new Date(),true,700));
            patientRepository.save(new Patient(null,"Yasmine",new Date(),false,460));
            patientRepository.save(new Patient(null,"Omar",new Date(),true,120));
            // Affichage de patients
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}
