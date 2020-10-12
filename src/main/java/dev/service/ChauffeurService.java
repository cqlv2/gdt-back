package dev.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.ChauffeurDtoRep;
import dev.entity.Chauffeur;
import dev.exception.ChauffeurException;
import dev.repository.ChauffeurRepository;

@Service
public class ChauffeurService {

	private ChauffeurRepository chaufRepo;
	private CollegueService colServ;

	public ChauffeurService(ChauffeurRepository chaufRepo,CollegueService colServ) {
		super();
		this.chaufRepo = chaufRepo;
		this.colServ=colServ;
	}
	
	protected Chauffeur getEntityById(Integer id) throws ChauffeurException {
		Optional<Chauffeur> chOpt=chaufRepo.findById(id);
		if(chOpt.isPresent())return chOpt.get();
		else throw new ChauffeurException("id non trouvée");
	}
	
	// transformation dto<-->entite
		protected ChauffeurDtoRep getDtoRep(Chauffeur c) {
			ChauffeurDtoRep cDto=new ChauffeurDtoRep();
			cDto.setId(c.getId());
			cDto.setMatricule(c.getMatricule());
			cDto.setPermis(c.getPermis());
			cDto.setTelephone(c.getTelephone());
			cDto.setInfo(colServ.getDtoRep(c.getInfo()));
			return cDto;
			
		}
}