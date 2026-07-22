package uebungen.Kapitel10BesondereTypen;

public class PirateJobs {

    public static <JOB extends Enum<JOB> & Job> void apply (JOB job) {
        System.out.println(job.name());
        System.out.println(job == EssentialJob.BOATSWAIN);
    }

    public static void main(String[] args) {
        apply(EssentialJob.BOATSWAIN);
        apply(NonEssentialJob.CABIN_BOY);
        //apply(new Job() {});
    }
    
}
