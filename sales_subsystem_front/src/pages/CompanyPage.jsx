import React from 'react'
import AddCompanyForm from '../components/company/AddCompanyForm'
import CompanyTable from '../components/company/CompanyTable'

const CompanyPage = ({ companies }) => {
  return (
    <>
      <CompanyTable companies={companies }/>
      <AddCompanyForm />
    </>
  )
}

export default CompanyPage