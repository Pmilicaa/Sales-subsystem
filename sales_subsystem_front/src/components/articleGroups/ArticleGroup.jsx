import { Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const ArticleGroup =({articleGroups})=>{
    let navigate = useNavigate()
    console.log(articleGroups)
    const getCompanyPib=(group)=>{
        let pibCompany;
        for (let index = 0; index < articleGroups.length; index++) {
            const pib = articleGroups[index].company.pib;
            if(group.company.pib === pib ){
                 pibCompany = articleGroups[index].company.pib;
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
                        {/* <td>{getCompanyPib(group)}</td> */}
                    </tr>)}
                </tbody>
            </Table>}
            <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add group</button></div>
        </>
    )
}
export default ArticleGroup;