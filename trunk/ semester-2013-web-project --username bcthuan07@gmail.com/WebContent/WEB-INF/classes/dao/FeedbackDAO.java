package dao;

import java.util.List;

import entity.Feedback;

public interface FeedbackDAO {

	public void addFeedback(Feedback feedback);
	public List<Feedback> listFeedback();
	public void removeFeedback(Integer id);
	public void updateFeedback(Feedback feedback);
}
