const ArticleGroup =({articleGroups})=>{
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
    return(
        <>
         <h1 className="center">Article groups</h1>
           {articleGroups && <table className="table">
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
            </table>}
        </>
    )
}
export default ArticleGroup;