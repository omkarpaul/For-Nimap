package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payload.ApiResponse;
import payload.CategoryDto;
import service.ServiceCategory;

@RestController
@RequestMapping("/categories")
public class CategoryController 
{
	@Autowired
	private ServiceCategory serCategory;
	private CategoryDto create;
	
	
	public ResponseEntity<CategoryDto>create(@RequestBody CategoryDto catDto)
	{
		CategoryDto create=this.serCategory.create(catDto);
		return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);
	}
	
	public ResponseEntity<CategoryDto>update(CategoryDto catDto)
	{
		CategoryDto update=this.serCategory.update(catDto);
		return new ResponseEntity<CategoryDto>(update,HttpStatus.OK);
	}
	
	public ResponseEntity<ApiResponse>delete(@PathVariable int catid)
	{
		this.serCategory.delete(catid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
	}
	
	public ResponseEntity<CategoryDto>getById(@PathVariable int catid)
	{
		CategoryDto getbyId = this.serCategory.getbyId(catid);
		return new ResponseEntity<CategoryDto>(getbyId,HttpStatus.OK);
	}
	
	public ResponseEntity<List<CategoryDto>>getAll()
	{
		List<CategoryDto> all = this.serCategory.getAll();
		return new ResponseEntity<List<CategoryDto>>(all,HttpStatus.OK);
	}
	
}
