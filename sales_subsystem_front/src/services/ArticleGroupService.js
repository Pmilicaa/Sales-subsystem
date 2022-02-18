import axios from 'axios';

export const getAllArticleGroups =async ()=>{
    const res = await axios.get('http://localhost:8080/articleGroups')
    console.log(res)
    return res.data;
 }