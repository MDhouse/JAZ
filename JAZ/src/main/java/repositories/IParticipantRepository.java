package repositories;

import java.util.List;

import domain.Participant;

public interface IParticipantRepository extends IRepository<Participant>
{
	public  List<Participant> withParticipant (Participant participants);


}
