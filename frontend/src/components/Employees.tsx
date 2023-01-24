import axios from "axios";
import { useEffect } from "react";
import { atom, useRecoilState } from "recoil"

type Props = {}

export const employeesData = atom<[] | [{id: number, email: string}]>({
    key: 'employeesData',
    default: []
})

function Employees({ }: Props) {

    const [employees, setEmployees] = useRecoilState(employeesData);

    const getEmployees = () => {
        axios.get('/api/v1/employees')
            .then(response => setEmployees(response.data.content))
            .catch(error => setEmployees([]));
    }

    useEffect(() => {
        getEmployees();
    }, [])

    return (
        <>
            {employees?.map(employee => {
                return <div>
                    <span>{`${employee.id}: ${employee.email}`}</span>
                </div>
            })}
        </>
    )
}

export default Employees