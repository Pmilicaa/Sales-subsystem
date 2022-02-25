import { Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const ArticleGroup = ({ articleGroups, companies }) => {
  let navigate = useNavigate()

  const handleClick = () => {
    navigate('/addArticleGroup', { replace: true });
  }

  return (
    <>
      <h1 className="center">Article groups</h1>
      {articleGroups && 
      <Table className="table" striped bordered hover>
        <thead className="thead-dark">
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Company PIB</th>
          </tr>
        </thead>
        <tbody>
          {articleGroups.map((group) =>
            <tr>
              <td>{group.name}</td>
              <td>{getCompanyPibByArticle(companies, group)}</td>
            </tr>)}
        </tbody>
      </Table>}
      <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add group</button></div>
    </>
  )
}

const getCompanyPibByArticle = (companies, articleGroup) => {
  let companyPib = "no company"
  companies.forEach(company => {
    company.articleGroups.forEach((companyArticleGroup) => {
      if (companyArticleGroup.id == articleGroup.id) {
        companyPib = company.pib
      }
    })
  });
  return companyPib
}

export default ArticleGroup;