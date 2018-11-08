package models;

// Date has our Date class, no doubts we need that
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateItinerary{
    private Date current;
	private Date goal;
    // Let's create this as a private object, so that we can access along the class
    
    public DateItinerary() {
        this.current = new Date();
        this.goal = new Date();
    }

    public DateItinerary(String currentDate, String nextDate)  throws Exception{
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
        this.current = myFormat.parse(currentDate);
        this.goal = myFormat.parse(nextDate);
    }
    public DateItinerary(Date currentDate, Date nextDate)  throws Exception{
        this.current = currentDate;
        this.goal = nextDate;
    }

  // Getters and Setters the way we learned
	public void setCurrent(Date current){
		this.current = current;
	}
	public void setGoal(Date goal){
		this.goal = goal;
	}

	public Date getCurrent(){
		return this.current;
	}
	public Date getGoal(){
		return this.goal;
	}
    public boolean isInTheFuture(){
        if(this.current.before(this.goal)) return true;
        else return false;
    }
    public boolean isInThePast(){
        if(this.current.after(this.goal)) return true;
        else return false;
    }

  @Override
	public String toString(){
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
	if (isInTheFuture()){
        return "Traveling from "+myFormat.format(this.current)
	 		+" to "+myFormat.format(this.goal)
	 		+" we are traveling to the future";
	}else if(isInThePast()){
	 	return "Traveling from "+myFormat.format(this.current)
	 		+" to "+myFormat.format(this.goal)
	 		+" we are traveling to the past";

    } else
    //If it is not in the past either in the future? It is probably today =)
	 	return "No trip on that";
	}

}