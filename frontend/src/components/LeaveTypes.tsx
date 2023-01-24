import axios from "axios";
import { useEffect } from "react";
import { atom, useRecoilState } from "recoil"

type Props = {}

export const leaveTypesData = atom<[] | [{id: number, name: string}]>({
    key: 'leaveTypesData',
    default: []
})

function LeaveTypes({ }: Props) {

    const [leaveTypes, setLeaveTypes] = useRecoilState(leaveTypesData);

    const getLeaveTypes = () => {
        axios.get('/api/v1/leave-types')
            .then(response => setLeaveTypes(response.data))
            .catch(error => setLeaveTypes([]));
    }

    useEffect(() => {
        getLeaveTypes();
    }, [])

    return (
        <>
            {leaveTypes?.map(leaveTypes => {
                return <div>
                    <span>{`${leaveTypes.id}: ${leaveTypes.name}`}</span>
                </div>
            })}
        </>
    )
}

export default LeaveTypes