package task2;

public class Office {

    Secretary secretary;
    Director director = new Director();
    Hr hr = new Hr();

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    void invitePeaople(Object human) {
    	//System.out.println(human);
        if(human instanceof WantAJob){
			hr.interview((WantAJob) human);
			//System.out.println(hr.getCandidates());
		}
    }
}
