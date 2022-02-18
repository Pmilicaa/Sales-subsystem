import axios from 'axios';

export const getAllArticleGroups =async ()=>{
    const res = await axios.get('http://localhost:8080/articleGroups')
    console.log(res)
    return res.data;
 }
 export const addArticleGroup =async (group)=>{
    console.log(group);
  
     return await axios
     .post('http://localhost:8080/addArticleGroups/', 
     group
     )
     .then(response => {
       return response.data;
     });
  }