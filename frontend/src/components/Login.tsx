import { redirectToGoogleLogin } from "../utils/authUtil"

type Props = {}

function Login({ }: Props) {

    return (
        <button onClick={redirectToGoogleLogin}>Login with Google</button>
    )
}

export default Login