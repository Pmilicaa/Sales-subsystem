import { Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const ArticleGroup =({articleGroups, companies})=>{
    let navigate = useNavigate()
    const getCompanyPib=(group)=>{
        let pibCompany;
        for (let index = 0; index < companies.length; index++) {
            const company = companies[index];
           for (let index = 0; index < company.articleGroups.length; index++) {
               const articleGroup = company.articleGroups[index];
               if(articleGroup.id === group.id){
                    pibCompany = company.pib
               }else{
                   pibCompany='no company'
               }
           }
            
        }return pibCompany;
    }
    const handleClick = ()=>{
        navigate('/addArticleGroup', { replace: true });
    }
    return(
        <>
         <h1 className="center">Article groups</h1>
           {articleGroups && <Table className="table" striped bordered hover>
                <thead className="thead-dark">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Company PIB</th>
                    </tr>
                </thead>
                <tbody>
                   {articleGroups.map((group)=>
                    <tr>
                        <td>{group.name}</td>
                        <td>{getCompanyPib(group)}</td>
                    </tr>)}
                </tbody>
            </Table>}
            <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add group</button></div>
        </>
    )
}
export default ArticleGroup;