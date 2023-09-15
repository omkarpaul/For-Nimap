package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nimaptest.Category;

import categoryRepsitory.CatRepository;
import payload.CategoryDto;
import payload.ModelMapper;
@Service

public class ServiceCategory 
{
	@Autowired
	private CatRepository catRepo;
	@Autowired
	private ModelMapper mapper;
	public Category create(CategoryDto dto)
	{
		Category cat=this.mapper.map(dto,Category.class);
		Category save = this.catRepo.save(cat);   
		return this.mapper.map(save,CategoryDto.class);
	}
	
	public CategoryDto update(CategoryDto olddto,int catid, Object newcatid)
	{
		this.catRepo.findById(catid).orElseThrow();
		olddto.setCatid(newcatid.getCatid());
		return null;
	}
	
	public void delete(int catid)
	{
		
	}
	
	public CategoryDto getbyId(int catid)
	{
		return null;
	}
	
	public List<CategoryDto> getAll()
	{
		return null;
	}
}
